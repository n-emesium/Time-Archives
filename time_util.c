#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
typedef struct custom_clock {
    unsigned int h;
    unsigned int m;
    unsigned int s;
} cclock;
typedef struct custom_timer {
    unsigned int h;
    unsigned int m;
    unsigned int s;     
} timer;
cclock *cinit(int h, int m, int s) {
    cclock *c1 = malloc(sizeof(cclock));
    c1->h = h;
    c1->m = m;
    c1->s = s;
    return c1;
}
void updatec(cclock *c1) {
    time_t now = time(NULL);
    struct tm *local = localtime(&now);
    c1->h = local->tm_hour;
    c1->m = local->tm_min;
    c1->s = local->tm_sec;
}
cclock *cnow() {
    cclock *c1 = malloc(sizeof(cclock));
    updatec(c1);
    return c1;
}
void mupdatec(cclock *c1, int h, int m, int s) {
    c1->h = h;
    c1->m = m;
    c1->s = s;
}
void printc(cclock *c1) {
    updatec(c1);
    printf("Current time: %02u:%02u:%02u\n", c1->h, c1->m, c1->s);
}
timer *tinit(int h, int m, int s) {
    timer *t1 = malloc(sizeof(timer));
    t1->h = h;
    t1->m = m;
    t1->s = s;
    return t1;
}
void updatet(timer *t1, int h, int m, int s) {
    t1->h = h;
    t1->m = m;
    t1->s = s;
    printf("Timer set for: %u hours, %u minutes, %u seconds\n", t1->h, t1->m, t1->s);
}
int start(timer *t1) {
    //unistd sleep() is in terms of seconds
    //1 min = 60 sec
    //x min = x * 60 seconds;
    //1 hour = 60 minutes
    //1 hour = 60 * 60 seconds = 3600 seconds;
    int x = t1->s + (60 * t1->m) + (3600 * t1->h);
    sleep(x);
    printf("Timer finished. Exited gracefully. It has been: %d hours; %d minutes; and %d seconds in total. \n",t1->h,t1->m,t1->s);
    return 0;
}
void printt(timer *t1) {
    printf("Timer set for: %u hours, %u minutes, %u seconds\n", t1->h, t1->m, t1->s);
}
int main() {
    cclock *c = cnow();
    updatec(c);
    printc(c);
    timer *t = tinit(0,0,5);
    start(t);
    free(c);
    free(t);
    return 0;
}