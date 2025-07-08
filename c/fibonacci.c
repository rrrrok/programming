#include <stdio.h>

int main() {
    int fibo0[41];
    int fibo1[41];
    
    fibo0[0] =1,fibo0[1] = 0;
    fibo1[0] = 0,fibo1[1] = 1;

    for (int i = 2; i <= 40; i++) {
        fibo0[i] = fibo0[i-1] + fibo0[i-2];
        fibo1[i] = fibo1[i-1] + fibo1[i-2];
    }

    int n;
    scanf("%d", &n);

    int num;

    while(n-- >0){
        scanf("%d", &num);
        printf("%d %d\n", fibo0[num], fibo1[num]);

    }
    return 0;
}