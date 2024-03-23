Luồng chấm công sơ bộ:
- Một công ty sẽ có nhiều bộ phận, hiện tại là 3: HR, TECH, SALE
- Mỗi bộ phận có 2 cấp: Quản lý và Nhân viên
- Một công ty có nhiều cơ sở, hiện tại có 2 cơ sở ở TP.HCM: Cơ sở Tân Bình và cơ sở Q9
- Nhân viên sẽ lên kế hoạch cho 1 tuần làm việc của mình => sẽ ghi lại:
- Thứ 2,3,4,5,6 mình sẽ làm việc ở cơ sở nào?
- Mình làm việc từ mấy giờ tới mấy giờ?
- Có nghỉ bệnh, nghỉ cá nhân gì không?
- Sau khi kết thúc 1 ngày làm việc, quản lý sẽ xác nhận nhân viên có làm đúng như kế hoạch đề ra không?
- Quản lý sẽ nắm được nhân viên đi làm mấy tiếng, bao nhiêu ngày để dễ dàng tính lương cụ thể


Timesheet Project được thực hiện theo thao tác CRUD của mô hình MVC nên sẽ có những tính năng sau:
- API tạo nhân viên mới - quản lý mới
- API gắn quản lý vào nhân viên (Mỗi nhân viên có một quản lý - một quản lý có thể có nhiều nhân viên)
- API sửa thông tin nhân viên - quản lý
- API xóa nhân viên (Cho nhân viên nghỉ việc)
  + Lúc nhân viên nghỉ cần phải lưu lại thông tin tại sao nghỉ? Nghỉ ngày nào? (Do quản lý nhập)
  + Không được xóa thông tin nhân viên ra khỏi hệ thống (Do có liên quan đến tính lương)
- API xóa quản lý (Cho quản lý nghỉ việc)
  + Khi xóa quản lý ra khỏi nhân viên thì nhân viên sẽ được hệ thống tự động thêm quản lý mới vào (ngẫu nhiên)
  + Hoặc là khi xóa sẽ chỉ định một quản lý khác để chuyển giao nhân viên từ quản lý sắp nghỉ này sang quản lý mới
- API cho nhân viên lên kế hoạch làm việc tuần (Dựa theo luồng chấm công sơ bộ)
- API cho quản lý xác nhận hoặc chỉnh sửa thời gian làm việc thực tế của nhân viên
- APi tính toán thời, tiền lương dự tính và thực tế
