# Ghi chú làm bài tập 
## BTCS1.cpp – Cài đặt và so sánh các thuật toán sắp xếp cơ bản
- Viết chương trình cho phép nhập mảng từ người dùng.
- Hiển thị mảng ban đầu.
- Thực hiện sắp xếp bằng các thuật toán:
  - Interchange Sort
  - Selection Sort
  - Insertion Sort
  - Bubble Sort
- Mỗi thuật toán được áp dụng riêng biệt và in kết quả ra màn hình.
- Dùng mảng phụ để giữ nguyên dữ liệu ban đầu.
##  BTCS3.c – Đo thời gian và số lần so sánh/hoán vị của các thuật toán sắp xếp
- Tự động tạo mảng ngẫu nhiên với nhiều kích thước khác nhau.
- Ghi nhận thời gian thực hiện, số lần so sánh và hoán vị.
- Các thuật toán đã triển khai:
  - Interchange Sort
  - Selection Sort
  - Insertion Sort
  - Bubble Sort
  - Heap Sort
  - Quick Sort
- Sử dụng hàm clock() để đo thời gian thực nghiệm.
## BTUD2.cpp – Sắp xếp đa thức theo bậc tăng dần
- Định nghĩa struct `SoHang` gồm hệ số và bậc.
- Nhập vào danh sách các số hạng của đa thức.
- Sắp xếp các số hạng theo thứ tự tăng dần của bậc.
- In ra đa thức sau khi sắp xếp theo định dạng `heso x^bac`.
## BTUD5.cpp – Xử lý ma trận, tìm dòng có tổng lớn nhất và sắp xếp dòng
- Nhập ma trận 2 chiều từ bàn phím (tối đa 50 dòng, 100 cột).
- Xuất ma trận vừa nhập ra màn hình.
- Tính tổng các phần tử trên từng dòng.
- Tìm dòng có tổng lớn nhất và in ra vị trí dòng đó.
- Thực hiện sắp xếp **các dòng** của ma trận theo **giảm dần tổng từng dòng**.
- Xuất lại ma trận sau khi sắp xếp.
-Các hàm đã sử dụng:
 - nhap() – nhập mảng 2 chiều
 - xuat() – in mảng
 - Tongdong() – tính tổng của 1 dòng bất kỳ
 - maxdong() – tìm dòng có tổng lớn nhất
 - SapXepDong() – sắp xếp các dòng theo tổng giảm dần
## BAITAP1.cpp – Cài đặt và ứng dụng cấu trúc dữ liệu Stack
- Cài đặt Stack bằng cấu trúc động (struct Stack với con trỏ int* a)
- Các thao tác cơ bản trên Stack:
  - InitStack() – khởi tạo ngăn xếp
  - Push() – thêm phần tử vào đỉnh
  - Pop() – lấy phần tử từ đỉnh
  - Peek() – xem phần tử đỉnh
  - IsEmpty() / IsFull() – kiểm tra trạng thái ngăn xếp
  - Clear() – giải phóng bộ nhớ động
  ## Dánhsachlienket.c – Quản lý danh sách liên kết đơn (Singly Linked List)
- Cài đặt cấu trúc Node chứa info và next.
- Cài đặt các thao tác cơ bản trên danh sách liên kết:
  - Init() – khởi tạo danh sách
  - IsEmpty()– kiểm tra danh sách có rỗng không
  - CreateNode() – tạo node mới
  - InsertFirst() – chèn node vào đầu danh sách
  - InsertAfter() – chèn node sau node chỉ định
  - DeleteFirst() – xóa phần tử đầu
  - DeleteAfter() – xóa phần tử sau node chỉ định
  - Remove() – xóa node có giá trị bất kỳ
  - RemoveOrder()– xóa node trong danh sách có thứ tự
  - Find() và FindOrder() – tìm kiếm phần tử
  - SelectionSort() – sắp xếp danh sách theo thứ tự tăng dần
  - ClearList() – xóa toàn bộ danh sách
 Các bài test trong hàm Test():
1. Kiểm tra danh sách rỗng 
2. Chèn 3 phần tử vào đầu danh sách: 30 → 20 → 10  
3. Xóa phần tử đầu tiên: kết quả sẽ là 20 → 10  
4. Xóa phần tử có giá trị 10 
5. Sắp xếp danh sách
6. Xóa toàn bộ danh sách và kiểm tra lại
