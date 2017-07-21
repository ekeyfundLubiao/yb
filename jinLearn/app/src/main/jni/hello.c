#include <jni.h>

JNIEXPORT jstringJNICALL
Java_com_longjoy_catskay_jinlearn_MainActivity_getNativeStringC(JNIEnv
*env,
jclass type)
{

// TODO


return (*env)->NewStringUTF(env, returnValue);
}