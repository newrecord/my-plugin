package com.github.newrecord.myplugin.ui

import com.ibm.icu.impl.IllegalIcuArgumentException
import com.intellij.openapi.fileEditor.OpenFileDescriptor
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.rootManager
import com.intellij.openapi.ui.DialogPanel
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.components.JBTabbedPane
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.gridLayout.HorizontalAlign
import java.awt.Dimension
import javax.swing.JComponent
import kotlin.reflect.KFunction
import kotlin.reflect.full.findAnnotation

private val PANELS = arrayOf(
    ::connectDialogPanel,
    ::settingsDialogPanel
)

class UiSwapSharedModuleDialog(private val project: Project?, dialogTitle: String) :
    DialogWrapper(project, false) {

    init {
        title = dialogTitle
        init()
    }

    override fun createCenterPanel(): JComponent? {
        val result = JBTabbedPane()
        result.minimumSize = Dimension(400, 300)
        result.preferredSize = Dimension(800, 600)
        for (panel in PANELS) {
            addDialog(panel, result)
        }
        return result
    }

    private fun addDialog(dialog: KFunction<DialogPanel>, tabbedPane: JBTabbedPane) {

        val annotation = dialog.findAnnotation<Info>()
            ?: throw IllegalIcuArgumentException("Info annotation is missed for: ${dialog.name}")

        val content = panel {
            row {
                // 탭 이름 하단 sub title
                label("Description: ${annotation.description}")
            }

            val dialogPanel = dialog.call()
            row {
                cell(dialogPanel).horizontalAlign(HorizontalAlign.FILL).resizableColumn()
            }
        }
        tabbedPane.add(annotation.title, content)
    }

}