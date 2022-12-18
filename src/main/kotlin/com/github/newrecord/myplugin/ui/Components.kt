package com.github.newrecord.myplugin.ui

import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.RowLayout
import com.intellij.ui.dsl.builder.panel

@Info(title = "Connect", description = "Submodule 연결 설정")
fun connectDialogPanel(): DialogPanel {
    return panel {
        row("Row1 label:") {
            textField()
            label("Some text")
        }

        row("Row2:") {
            label("This text is aligned with previous row")
        }

        row("Row3:") {
            label("Rows 3 and 4 are in common parent grid")
            textField()
        }.layout(RowLayout.PARENT_GRID)

        row("Row4:") {
            textField()
            label("Rows 3 and 4 are in common parent grid")
        }.layout(RowLayout.PARENT_GRID)
    }
}

@Info(title = "Settings", description = "환경설정")
fun settingsDialogPanel(): DialogPanel {
    return panel {
        row("Row1 label:") {
            textField()
            label("Some text")
        }

        row("Row2:") {
            label("This text is aligned with previous row")
        }

        row("Row3:") {
            label("Rows 3 and 4 are in common parent grid")
            textField()
        }.layout(RowLayout.PARENT_GRID)

        row("Row4:") {
            textField()
            label("Rows 3 and 4 are in common parent grid")
        }.layout(RowLayout.PARENT_GRID)
    }
}