#include <jni.h>

JNIEXPORT jstring JNICALL
Java_jp_study_ndktest_MainActivity_getMsgFromJni(JNIEnv *env, jobject instance) {
    // TODO
    return (*env)->NewStringUTF(env, "Hello JNI");
}