#include <iostream>
using namespace std;

long long dem(long long n) {
    long long k = 0;
    while (n > 0) {
        n /= 5;
        k += n;
    }
    return k;
}

int main() {
    long long n;
    while (cin >> n) {
        cout << dem(n) << "\n";
    }
    return 0;
}
