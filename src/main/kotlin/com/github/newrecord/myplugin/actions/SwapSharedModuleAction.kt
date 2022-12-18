package com.github.newrecord.myplugin.actions

import com.github.newrecord.myplugin.ui.UiSwapSharedModuleDialog
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction


class SwapSharedModuleAction : DumbAwareAction() {
    override fun actionPerformed(e: AnActionEvent) {
        e.project?.also {
            val isOK = UiSwapSharedModuleDialog(it, "Swap shared module").showAndGet()
            if (isOK) {
                // TODO: ok 시 추가 로직
            }
        }
    }
}