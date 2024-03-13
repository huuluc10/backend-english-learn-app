<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password OTP</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
        }
        .header {
            background-color: #3D85C6;
            padding: 20px;
            color: #ffffff;
            text-align: center;
        }
        .content {
            padding: 20px;
            text-align: center;
            line-height: 1.6;
        }
        .otp {
            font-size: 32px;
            color: #333;
            margin: 20px 0;
            padding: 10px;
            border: 1px dashed #3D85C6;
            display: inline-block;
        }
        .footer {
            padding: 10px;
            text-align: center;
            background-color: #3D85C6;
            color: #ffffff;
        }
        a {
            color: #3D85C6;
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Forgot Password Verification</h1>
    </div>
    <div class="content">
        <p>Chúng tôi đã nhận được yêu cầu đặt lại mật khẩu của bạn. Vui lòng sử dụng mã OTP dưới đây để tiếp tục quá trình:</p>
        <div class="otp">${code}</div>
        <p>Mã này sẽ hết hạn trong 5 phút. Đừng chia sẻ mã này với bất kỳ ai.</p>
        <p>Nếu bạn không yêu cầu đặt lại mật khẩu, có thể ai đó đã cố gắng truy cập vào tài khoản của bạn. Vui lòng bỏ qua email này.</p>
        <p>Nếu có bất kỳ thắc mắc nào, xin vui lòng liên hệ với chúng tôi.</p>
    </div>
    <div class="footer">
        Your Trusty App Team
    </div>
</div>
</body>
</html>