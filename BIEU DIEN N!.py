#include <iostream>
using namespace std;

int nt[200], m;
bool check[1001];

void sang() {
    for (int i = 2; i <= 1000; i++) check[i] = true;
    for (int i = 2; i <= 1000; i++) {
        if (check[i]) {
            nt[m++] = i;
            for (int j = i * i; j <= 1000; j += i) check[j] = false;
        }
    }
}

int mu(int n, int p) {
    int k = 0;
    while (n > 0) {
        n /= p;
        k += n;
    }
    return k;
}

int main() {
    sang();
    int n;
    while (cin >> n) {
        int a[200], len = 0;
        for (int i = 0; i < m; i++) {
            if (nt[i] > n) break;
            a[len++] = mu(n, nt[i]);
        }
        while (len > 0 && a[len - 1] == 0) len--;
        for (int i = 0; i < len; i++) {
            if (i > 0) cout << " ";
            cout << a[i];
        }
        cout << "\n";
    }
    return 0;
}
