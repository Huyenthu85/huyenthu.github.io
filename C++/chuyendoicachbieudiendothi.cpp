#include <bits/stdc++.h>
using namespace std;
int n, m; 
vector<vector<int>> MaTranSangDSKe(vector<vector<int>> &mat) {
    vector<vector<int>> ds(n + 1);
    for (int i = 1; i <= n; i++) 
    {
        for (int j = 1; j <= n; j++)
        {
            if (mat[i][j] == 1) 
            {
                ds[i].push_back(j);
            }
        }
    }
    return ds;
}
vector<pair<int,int>> MaTranSangDSCanh(vector<vector<int>> &mat)
{
    vector<pair<int,int>> dsCanh;
    for (int i = 1; i <= n; i++)
    {
        for (int j = i; j <= n; j++) 
        { 
            if (mat[i][j] == 1) 
            {
                dsCanh.push_back({i, j});
            }
        }
    }
    return dsCanh;
}

vector<vector<int>> DSSangMaTran(vector<vector<int>> &ds) 
{
    vector<vector<int>> mat(n + 1, vector<int>(n + 1, 0));
    for (int i = 1; i <= n; i++) 
    {
        for (int v : ds[i])
        {
            mat[i][v] = 1;
        }
    }
    return mat;
}

vector<pair<int,int>> DSSangDSCanh(vector<vector<int>> &ds)
{
    vector<pair<int,int>> dsCanh;
    for (int i = 1; i <= n; i++) 
    {
        for (int v : ds[i])
        {
            if (i <= v) dsCanh.push_back({i, v}); 
        }
    }
    return dsCanh;
}
vector<vector<int>> DSCanhSangMaTran(vector<pair<int,int>> &dsCanh) 
{
    vector<vector<int>> mat(n + 1, vector<int>(n + 1, 0));
    for (auto e : dsCanh)
    {
        int u = e.first, v = e.second;
        mat[u][v] = mat[v][u] = 1;
    }
    return mat;
}
vector<vector<int>> DSCanhSangDSKe(vector<pair<int,int>> &dsCanh)
{
    vector<vector<int>> ds(n + 1);
    for (auto e : dsCanh)
    {
        int u = e.first, v = e.second;
        ds[u].push_back(v);
        ds[v].push_back(u); 
    }
    return ds;
}
void InMaTran(vector<vector<int>> &mat)
{
    for (int i = 1; i <= n; i++) 
    {
        for (int j = 1; j <= n; j++)
            cout << mat[i][j] << " ";
        cout << "\n";
    }
}

void InDSKe(vector<vector<int>> &ds)
{
    for (int i = 1; i <= n; i++) 
    {
        cout << i << ": ";
        for (int v : ds[i]) cout << v << " ";
        cout << "\n";
    }
}

void InDSCanh(vector<pair<int,int>> &dsCanh) 
{
    for (auto e : dsCanh) 
    {
        cout << e.first << " - " << e.second << "\n";
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout << "Nhap so dinh va so canh: ";
    cin >> n >> m;
    vector<pair<int,int>> dsCanh;
    cout << "Nhap " << m << " canh (u v): ";
    for (int i = 0; i < m; i++) 
    {
        int u, v; cin >> u >> v;
        dsCanh.push_back({u, v});
    }
    cout << "Danh sach canh: ";
    InDSCanh(dsCanh);
    auto mat = DSCanhSangMaTran(dsCanh);
    cout << "Ma tran ke: ";
    InMaTran(mat);
    auto dsKe = DSCanhSangDSKe(dsCanh);
    cout << "Danh sach ke: ";
    InDSKe(dsKe);
    return 0;
}
