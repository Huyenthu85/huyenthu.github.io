# -Tuần 1-
## BÀI 1. BỘ BA (BOBA.*)
Cho một xâu văn bản chỉ gồm các chữ cái la tinh in hoa. Ta gọi một bộ ba là dãy gồm ba chữ cái latinh in hoa liên tiếp trong xâu.  
Hãy tìm số lần xuất hiện của bộ ba xuất hiện nhiều nhất như là xâu con gồm 3 ký tự liên tiếp trong xâu văn bản đã cho.  
Ví dụ: Trong xâu văn bản ‘DAIHOCKHOAHOCTUNHIENTHANHPHOHOCHIMINH’ xâu con
‘HOC’ xuất hiện nhiều nhất (3 lần), còn trong xâu văn bản ‘AAAAAD’ xâu ‘AAA’ xuất hiện nhiều nhất (3 lần).  
Dữ liệu: Vào từ bàn phím gồm:  
 • Dòng đầu tiên chứa số nguyên T - số lượng Tests (1 ≤ T ≤ 10),
 • T dòng tiếp theo, mỗi dòng chứa thông tin về một test, gồm một xâu văn bản gồm không quá 106
chữ cái la tinh in hoa.  
Kết quả: Ghi ra màn hình gồm T dòng, mỗi dòng chứa một số nguyên. Dòng thứ i chứa kết quả tương ứng với Test thứ i (i = 1÷T) là số lần xuất hiện nhiều nhất tìm được.
### 1.Ý tưởng thực hiện :
  Nhập số lượng test.  
  Với mỗi chuỗi: duyệt qua tất cả các bộ ba liên tiếp, đếm số lần xuất hiện bằng dict.  
  Lấy giá trị đếm lớn nhất và lưu vào kq.  
  Sau cùng in ra tất cả kết quả.   
## BÀI 2. DÃY SỐ HOÁN VỊ (DAYHV.*)
Cho số tự nhiên N và dãy gồm N số nguyên A1, A2, ..., AN. (N≤1000, │Ai│≤10000).  
Dãy A gọi là một hoán vị nếu trong dãy xuất hiện tất cả các số từ 1 tới N.  
Yêu cầu: Hãy kiểm tra xem dãy có phải là một hoán vị hay không?  
Dữ liệu: Nhập từ bàn phím:  
• Dòng đầu tiên chứa số nguyên N – số lượng phần tử của dãy.  
• Dòng hai chứa N số nguyên cách nhau bởi khoảng trắng, biểu diễn dãy A1, A2, ..., 
AN.  
Kết quả: Xuất ra màn hình, chứa chuỗi YES nếu dãy là một hoán vị, ngược lại chứa 
chữ NO.  
### 1. Ý tưởng thực hiện :
Đọc N và dãy A.  
Kiểm tra xem tất cả phần tử của A có thuộc [1..N] không.  
Dùng tập hợp (set) hoặc mảng đánh dấu để loại trùng và đếm số phần tử khác nhau.  
Nếu sau khi loại trùng, tập hợp có đúng N phần tử và chính xác là {1,2,…,N} → in 
YES.  
Ngược lại → in NO.  
## BÀI 3. BIỂU DIỄN N! (ANALYSE.*)
Giai thừa N, ký hiệu N! là tích tất cả các số nguyên từ 1 đến N. Giai thừa N tăng rất 
nhanh, ví dụ, 5! =120, 10! = 3628800. Một cách để xác định số lớn như vậy, người ta chỉ ra số lần xuất hiện các số nguyên tố trong phân tích của nó ra thừa số nguyên tố. Ví dụ, 825 có thể xác định bởi dãy (0 1 2 0 1) có nghĩa là 825 = 20.31.52.70.111  
Yêu cầu: Cho số nguyên dương N ≤ 1000. Hãy tìm cách biểu diễn N! dưới dạng số lần xuất hiện các
số nguyên tố trong phân tích N! ra các thừa số nguyên tố.  
Dữ liệu: Nhập bàn phím gồm nhiều dòng, mỗi dòng chứa 1 số nguyên N (2 ≤ N ≤ 1000).  
Kết quả: Xuất ra màn hình, mỗi dòng tương ứng với 1 dòng trong tập tin dữ liệu vào là 
dãy số thể hiện biểu diễn dưới dạng phân tích thành số nguyên tố của N! (phần tử cuối cùng của dãy phải là số dương).
### 1.Ý tưởng thực hiện 
Đầu tiên sinh ra tất cả số nguyên tố ≤ 1000 (vì N≤1000N)  
Với mỗi số nguyên N nhập vào:  
Với mỗi số nguyên tố p≤N , tính số mũ của p trong phân tích N! bằng công thức:
ep(N!)=N/p+N/p2+N/p3+…  
Lưu lại kết quả.  
In ra các số mũ theo thứ tự số nguyên tố tăng dần, bỏ các số 0 ở cuối
## BÀI 4. SỐ CHỮ SỐ KHÔNG TẬN CÙNG N! (SOKHONG.*)
Cho N là số nguyên dương với N<=2.109. Hãy tìm số chữ số 0 tận cùng của N!.  
Dữ liệu: Vào từ bàn phím gồm một số dòng, mỗi dòng ghi một số nguyên dương N..  
Kết quả: Với mỗi dòng, ghi ra màn hình trên một dòng tương ứng số chữ số 0 tận cùng 
của N!.  
### 1. Ý tưởng thực hiện 
Số 0 tận cùng trong N! xuất hiện khi trong tích có cặp thừa số 2×5  
Vì số mũ của 2 luôn nhiều hơn số mũ của 5 trong N!, nên ta chỉ cần đếm số mũ của 5.  
Công thức:  
Số 0=N/5 + N/25 + N/125 +...  
(lấy phần nguyên).  
Dừng khi 5k>N
# -Tuần 2-
