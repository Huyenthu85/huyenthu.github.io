#include <iostream>
#include <fstream>
using namespace std;
void Doc(string& ten, int a[100][100], int &n )
{
    ifstream file(ten);
    if (file.is_open() == false)
    {
        cout << "Khong the mo file " << ten << endl;
        return;
    }
    file >> n;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            file >> a[i][j];
        }
    }
    cout << "mang cac so nguyen trong file la :\n";
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;
    file.close();
}
void tinhbac(int a[100][100], int n)
{
    cout<<n<<endl;
    for (int i = 0; i < n; i++)
    {
        int dem = 0;
        for (int j = 0; j < n; j++)
        {
            if (a[i][j] > 0)
            {
                dem++;
            }
        }
        cout << dem << endl;
    }
}

int main()
{
    string ten;
    int a[100][100];
    int n;

    cout << "Moi ban nhap ten file can doc: ";
    cin >> ten;
    cout<<n;
    Doc(ten,a,n);
    tinhbac(a, n);
    return 0;
}
