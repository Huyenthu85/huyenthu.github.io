#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef int DataType;

typedef struct node {
    DataType info;
    struct node* next;
} Node;

bool IsEmpty(Node* pHead) {
    return (pHead == NULL);
}

void Init(Node** pHead) {
    *pHead = NULL;
}

Node* CreateNode(int X) {
    Node* p = (Node*)malloc(sizeof(Node));
    if (!p) {
        printf("Lỗi cấp phát bộ nhớ!\n");
        return NULL;
    }
    p->info = X;
    p->next = NULL;
    return p;
}

void ShowList(Node* pHead) {
    if (pHead == NULL) {
        printf("Danh sách rỗng\n");
        return;
    }
    for (Node* p = pHead; p != NULL; p = p->next)
        printf("%d -> ", p->info);
    printf("NULL\n");
}

Node* FindOrder(Node* pHead, int x) {
    bool found = false;
    Node* p = pHead;
    while ((p != NULL) && (!found)) {
        if (p->info == x)
            found = true;
        else if (p->info < x)
            p = p->next;
        else
            p = NULL;
    }
    return found ? p : NULL;
}

Node* Find(Node* pHead, int x) {
    for (Node* p = pHead; p != NULL; p = p->next)
        if (p->info == x)
            return p;
    return NULL;
}

void InsertFirst(Node** pHead, int x) {
    Node* p = CreateNode(x);
    if (p) {
        p->next = *pHead;
        *pHead = p;
    }
}

void InsertAfter(Node* p, int x) {
    if (p) {
        Node* q = CreateNode(x);
        if (q) {
            q->next = p->next;
            p->next = q;
        }
    }
}

Node* Remove(Node** pHead, int x) {
    Node *tp = NULL;
    Node *p = *pHead;
    while (p && p->info != x) {
        tp = p;
        p = p->next;
    }
    if (p) {
        if (p == *pHead) 
            *pHead = p->next;
        else
            tp->next = p->next;
        free(p);
    }
    return *pHead;
}

Node* RemoveOrder(Node** pHead, int x) {
    Node *tp = NULL;
    Node *p = *pHead;
    while (p && p->info < x) {
        tp = p;
        p = p->next;
    }
    if (p && p->info == x) {
        if (p == *pHead)
            *pHead = p->next;
        else
            tp->next = p->next;
        free(p);
    }
    return *pHead;
}

void DeleteFirst(Node** pHead) {
    if (!IsEmpty(*pHead)) {
        Node* p = *pHead;
        *pHead = (*pHead)->next;
        free(p);
    }
}

void DeleteAfter(Node* p) {
    if (p && p->next) {
        Node* q = p->next;
        p->next = q->next;
        free(q);
    }
}

void ClearList(Node** pHead) {
    Node* p;
    while (*pHead) {
        p = *pHead;
        *pHead = (*pHead)->next;
        free(p);
    }
}

void SelectionSort(Node** pHead) {
    for (Node* p = *pHead; p && p->next; p = p->next) {
        Node* pMin = p;
        for (Node* q = p->next; q; q = q->next)
            if (q->info < pMin->info)
                pMin = q;
        int temp = p->info;
        p->info = pMin->info;
        pMin->info = temp;
    }
}

void Test() {
    Node* pHead;
    Init(&pHead);
    printf("Test 1: Kiểm tra danh sách rỗng\n");
    printf(IsEmpty(pHead) ? "ĐẠT\n" : "KHÔNG ĐẠT\n");

    printf("Test 2: Chèn phần tử vào đầu\n");
    InsertFirst(&pHead, 10);
    InsertFirst(&pHead, 20);
    InsertFirst(&pHead, 30);
    ShowList(pHead);

    printf("Test 3: Xóa phần tử đầu tiên\n");
    DeleteFirst(&pHead);
    ShowList(pHead);

    printf("Test 4: Xóa phần tử có giá trị 10\n");
    Remove(&pHead, 10);
    ShowList(pHead);

    printf("Test 5: Sắp xếp danh sách\n");
    SelectionSort(&pHead);
    ShowList(pHead);

    printf("Test 6: Xóa toàn bộ danh sách\n");
    ClearList(&pHead);
    printf(IsEmpty(pHead) ? "ĐẠT\n" : "KHÔNG ĐẠT\n");
}

int main() {
    Test();
    return 0;
} 
