package com.github.newrecord.myplugin.services

import com.github.newrecord.myplugin.MyBundle

class MyApplicationService {

    init {
        println(MyBundle.message("applicationService"))

//        System.getenv("CI")
//            ?: TODO("[MyApplicationService] Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }
}
