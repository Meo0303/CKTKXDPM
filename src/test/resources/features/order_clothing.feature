Feature: đặt mua quần áo
Như là một khách hàng mua sắm tại VietFashion
Tôi muốn biết tổng tiền của đơn hàng đặt mua quần áo
Để được hưởng ưu đãi giảm giá nhóm và đỡ phải tốn thời gian tính bằng giấy

Scenario Outline: đặt mua lẻ dưới 3 bộ quần áo hợp lệ với mức giá tiêu chuẩn
Given số lượng quần áo <quantity> và đơn giá <unit_price>
When tôi thực hiện đặt mua quần áo
Then tôi được thông báo giá trị là <result> <color>
And lưu kết quả <save_result>
And ngày hiện tại <current_date>

Examples:
| current_date | quantity | unit_price | result | color | save_result | reason                     |
| 03/11/2026   | 1        | 150        | 150    | pink  | true        | mua le 1 bo nguyen gia     |
| 03/11/2026   | 2        | 100        | 200    | pink  | true        | mua le 2 bo nguyen gia     |

Scenario Outline: đặt mua theo nhóm từ 3 đến 20 bộ quần áo hợp lệ được giảm giá 10 phần trăm
Given số lượng quần áo <quantity> và đơn giá <unit_price>
When tôi thực hiện đặt mua quần áo
Then tôi được thông báo giá trị là <result> <color>
And lưu kết quả <save_result>
And ngày hiện tại <current_date>

Examples:
| current_date | quantity | unit_price | result | color | save_result | reason                     |
| 03/11/2026   | 3        | 100        | 270    | red   | true        | mua nhom 3 bo giam 10%     |
| 03/11/2026   | 4        | 100        | 360    | red   | true        | mua nhom 4 bo giam 10%     |
| 03/11/2026   | 10       | 200        | 1800   | red   | true        | mua nhom 10 bo giam 10%    |
| 03/11/2026   | 20       | 100        | 1800   | red   | true        | mua nhom toi da 20 bo      |

Scenario Outline: đặt mua quần áo thất bại khi số lượng vượt quá giới hạn 20 bộ mỗi đơn
Given số lượng quần áo <quantity> và đơn giá <unit_price>
When tôi thực hiện đặt mua quần áo
Then tôi được thông báo giá trị là <result> <color>
And lưu kết quả <save_result>
And ngày hiện tại <current_date>

Examples:
| current_date | quantity | unit_price | result | color | save_result | reason                     |
| 03/11/2026   | 21       | 100        | -1     | gray  | false       | vuot qua gioi han 20 bo    |
| 03/11/2026   | 25       | 100        | -1     | gray  | false       | vuot qua gioi han 20 bo    |

Scenario Outline: đặt mua quần áo thất bại khi dữ liệu đầu vào không hợp lệ hoặc bằng không
Given số lượng quần áo <quantity> và đơn giá <unit_price>
When tôi thực hiện đặt mua quần áo
Then tôi được thông báo giá trị là <result> <color>
And lưu kết quả <save_result>
And ngày hiện tại <current_date>

Examples:
| current_date | quantity | unit_price | result | color | save_result | reason                     |
| 03/11/2026   | 0        | 100        | -1     | gray  | false       | so luong bang 0            |
| 03/11/2026   | -2       | 100        | -1     | gray  | false       | so luong am                |
| 03/11/2026   | abc      | 100        | -1     | gray  | false       | sai dinh dang so           |
