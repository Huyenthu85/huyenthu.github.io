#include <iostream>
using namespace std;

int main() {
    int nx, ny, nz;
    cin >> nx;
    bool a[10001] = {0}, b[10001] = {0}, c[10001] = {0};

    for (int i = 0; i < nx; i++) {
        int x;
        cin >> x;
        a[x] = true;
    }

    cin >> ny;
    for (int i = 0; i < ny; i++) {
        int y;
        cin >> y;
        b[y] = true;
    }

    cin >> nz;
    for (int i = 0; i < nz; i++) {
        int z;
        cin >> z;
        c[z] = true;
    }

    int dem = 0;
    int kq[10001], len = 0;

    for (int i = 0; i <= 10000; i++) {
        if (a[i] && b[i] && c[i]) {
            kq[len++] = i;
            dem++;
        }
    }

    cout << dem << "\n";
    for (int i = 0; i < len; i++) {
        if (i > 0) cout << " ";
        cout << kq[i];
    }
    cout << "\n";

    return 0;
}
