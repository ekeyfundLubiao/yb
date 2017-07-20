//
// Created by Administrator on 2017/7/19.
//

#include <stdlib.h>
#include <stdio.h>
#include "com_longjoy_catskay_jinlearn_MainActivity.h"


JNIEXPORT jstring
        JNICALL Java_com_longjoy_catskay_jinlearn_MainActivity_getNativeStringC
                (JNIEnv *env, jclass jclass){

                    return (*env)->NewStringUTF(env, "Hello from JNI ! ");;
}