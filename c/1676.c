#include <stdio.h>

int main(){
    int n;
    scanf("%d", &n);

    int result; 

    int cnt = 0;
    
    for (int i=1; i<=n; i++){
        if(i % 5 ==0)
            cnt++;
        if(i % 25 ==0)
            cnt++;
        if(i % 125 ==0)
            cnt++;
    }
    printf("%d",cnt);
    return 0;
}