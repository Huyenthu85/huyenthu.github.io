#include <iostream>
#include <string>
#include <cctype>
using namespace std;
struct Stack 
{
    int top;
    int count;
    int size;
    int *a;
};
void InitStack(Stack &s, int size) 
{
    s.top = -1;
    s.count = 0;
    s.size = size;
    s.a = new int[s.size];
}

bool IsEmpty(Stack s) 
{
    return s.top == -1;
}
bool IsFull(Stack s) 
{
    return s.top == s.size - 1;
}
void Push(Stack &s, int value) 
{
    if (IsFull(s)) {
        cout << "Ngăn xếp đầy!\n";
        return;
    }
    s.a[++s.top] = value;
    s.count++;
}
int Pop(Stack &s) 
{
    if (IsEmpty(s))
    {
        cout << "Ngăn xếp rỗng!\n";
        return -1;
    }
    s.count--;
    return s.a[s.top--];
}
int Peek(Stack s)
{
    if (IsEmpty(s)) 
    {
        cout << "Ngăn xếp rỗng!\n";
        return -1;
    }
    return s.a[s.top];
}
void Clear(Stack &s)
{
    delete[] s.a;
    s.top = -1;
    s.count = 0;
    s.size = 0;
}

void DaoSo(int n)
{
    Stack s;
    InitStack(s, 10);
    while (n > 0) 
    {
        Push(s, n % 10);
        n /= 10;
    }
    cout << "Số sau khi đảo: ";
    while (!IsEmpty(s)) 
    {
        cout << Pop(s);
    }
    cout << endl;
    Clear(s);
}
bool KiemTraDoiXung(string str) 
{
    Stack s;
    InitStack(s, str.length());
    for (char c : str)
    {
        Push(s, c);
    }
    for (char c : str) 
    {
        if (c != Pop(s))
        {
            Clear(s);
            return false;
        }
    }
    Clear(s);
    return true;
}
void ChuyenNhiPhan(int n) 
{
    Stack s;
    InitStack(s, 32);
    while (n > 0) 
    {
        Push(s, n % 2);
        n /= 2;
    }
    cout << "Số nhị phân: ";
    while (!IsEmpty(s)) 
    {
        cout << Pop(s);
    }
    cout << endl;
    Clear(s);
}
string TrungToSangHauTo(string exp) 
{
    Stack s;
    InitStack(s, exp.length());
    string result = "";
    for (char c : exp) 
    {
        if (isalnum(c)) 
        {
            result += c;
        } else if (c == '(') 
        {
            Push(s, c);
        } else if (c == ')')
        {
            while (!IsEmpty(s) && Peek(s) != '(')
            {
                result += (char)Pop(s);
            }
            Pop(s);
        } else
        {
            while (!IsEmpty(s) && Peek(s) != '(') 
            {
                result += (char)Pop(s);
            }
            Push(s, c);
        }
    }
    while (!IsEmpty(s)) 
    {
        result += (char)Pop(s);
    }
    Clear(s);
    return result;
}

int main() 
{
    Stack s;
    InitStack(s, 5);
    Push(s, 10);
    Push(s, 20);
    Push(s, 30);
    cout << "Phần tử đầu tiên: " << Peek(s) << endl;
    cout << "Lấy ra: " << Pop(s) << endl;
    cout << "Lấy ra: " << Pop(s) << endl;
    Clear(s);
    cout << "\n-- Đảo số --\n";
    DaoSo(1234);
    cout << "\n-- Kiểm tra đối xứng --\n";
    string testStr = "madam";
    cout << "Chuỗi '" << testStr << "' có đối xứng không? " << (KiemTraDoiXung(testStr) ? "Có" : "Không") << endl;
    cout << "\n-- Chuyển thập phân sang nhị phân --\n";
    ChuyenNhiPhan(10);
    cout << "\n-- Chuyển trung tố sang hậu tố --\n";
    string infixExp = "a+b*(c^d-e)^(f+g*h)-i";
    cout << "Biểu thức hậu tố: " << TrungToSangHauTo(infixExp) << endl;
    return 0;
}
