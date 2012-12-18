#include <stdio.h>
#include <unistd.h>

typedef unsigned long long ticks;

static __inline__ ticks getticks(void) {
     unsigned a, d;
     asm volatile("rdtsc" : "=a" (a), "=d" (d));

     return (((ticks)a) | (((ticks)d) << 32));
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
