/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
#include <string.h>
#include <jni.h>
#include <android/log.h>

#include <GLES2/gl2.h>
#include <GLES2/gl2ext.h>

#include <stdio.h>
#include <stdlib.h>
#define TAG "nate"
#define  LOGV(...) _android_log_print(ANDROID_LOG_DEBUG,TAG,_VA_ARGS_)

jstring Java_com_longjoy_catskay_jinlearn_MainActivity_getNativeStringC(JNIEnv *env,
                                                                        jobject thiz);

{


return (*env)->
NewStringUTF(env,
"Hello from JNI ");
}

void Java_com_longjoy_catskay_jinlearn_MainActivity_updateFile
        (JNIEnv *env,
         jobject thiz, jstring path) {

    const char *file_path = (*env)->GetStringUTFChars(env, path, NULL);
    if (file_path != NULL) {
        LOGV("from c file_path s%", file_path)
    }

}
