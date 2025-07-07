#include <stdio.h>
#include <stdlib.h>
//백준1920번 문제: 수 찾기
void mergesort(int arr[], int left, int right) {
    if (left >= right) return;

    int mid = (left + right) / 2;
    mergesort(arr, left, mid);
    mergesort(arr, mid + 1, right);

    int i = left, j = mid + 1, k = 0;
    int size = right - left + 1;
    int* temp = (int*)malloc(sizeof(int) * size);

    while (i <= mid && j <= right) {
        if (arr[i] < arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }

    while (i <= mid) {
        temp[k++] = arr[i++];
    }
    
    while (j <= right) {
        temp[k++] = arr[j++];
    }

    for (i = left; i <= right; i++) {
        arr[i] = temp[i - left];
    }
    free(temp);
}
int binary_search(int arr[], int size, int target) {
    int left = 0, right = size - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return 1; // 찾은 경우
        } else if (arr[mid] < target) {
            left = mid + 1; // 오른쪽 절반 탐색
        } else {
            right = mid - 1; // 왼쪽 절반 탐색
        }
    }
    return 0; // 찾지 못한 경우
}

int main(){
    // 사용자 입력
    int n,m;
    int A[100000],B[100000];
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        scanf("%d", &A[i]);
    }
    scanf("%d", &m);
    for(int i = 0; i < m; i++){
        scanf("%d", &B[i]);
    }
    mergesort(A, 0, n - 1);
    
    for(int i = 0; i < m; i++) {
        printf("%d\n", binary_search(A, n, B[i]));
    }
    
    return 0;
}