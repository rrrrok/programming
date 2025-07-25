    #include <stdio.h>

    int dp[1000001];


    int min(int a, int b) {
        return a < b ? a : b;
    }

    int main() {
        int N;
        dp[1] = 0;

        scanf("%d", &N);

        for (int i =2; i<N+1; i++) {
            dp[i] = dp[i-1] + 1;

            if (i %2 ==0){
                dp[i] = min(dp[i], dp[i/2] + 1);
            }

            if (i %3 ==0){
                dp[i] = min(dp[i], dp[i/3] + 1);
            }
        }


        printf("%d", dp[N]);

    }


