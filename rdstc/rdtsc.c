#include <stdio.h>
#include <unistd.h>

#include <jni.h>

#include "rdstc.h"

typedef unsigned long long ticks;

static __inline__ ticks getticks(void) {
     unsigned a, d;
     asm volatile("cpuid");
     asm volatile("rdtsc" : "=a" (a), "=d" (d));

     return (((ticks)a) | (((ticks)d) << 32));
}

/*
static __inline__ ticks rdtscp(void) {
	unsigned lo, hi;
    asm volatile("rdtscp" : "=a"(lo), "=d"(hi));
    return (ticks)hi << 32 | lo;
}
*/

JNIEXPORT jlong JNICALL Java_org_relgames_clocktest_NativeRdstc_rdstc (JNIEnv *env, jclass myClass) {
	return getticks();
}


int main(){
    ticks tick, tick1;

	for (;;) {
		tick = getticks();
		sleep(1);
		tick1 = getticks();
		printf("%Ld\n", tick1-tick);
    }

	return 0;
}
