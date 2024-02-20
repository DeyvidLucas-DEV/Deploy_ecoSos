<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>Alerta de alteração de dados, ${nome}.</title>
  <style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    .container {
        max-width: 600px;
        margin: 0 auto;
    }

    .header {
        background-color: #0a296d;
        padding: 20px 0;
        text-align: center;
    }

    .header img {
        max-width: 100%;
        height: auto;
    }

    .content {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        margin-top: 20px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    .content p {
        font-size: 18px;
        color: #555;
        margin-bottom: 20px;
    }

    .footer {
        background-color: #333;
        text-align: center;
        padding: 10px 0;
        color: #fff;
        position: relative;
        bottom: 0;
        width: 100%;
        margin-top: 20px;
    }
  </style>
</head>

<body>
<div class="container">
  <div class="header">
    <img src="/assets/lines_cycle_leaf.jpg" alt="SOSLogo"/>
  </div>

  <div class="content">
    <p>Olá <strong>${nome}</strong>,</p>
    <p>Seus dados foram atualizados no nosso sistema.</p>
    <p>Qualquer dúvida é só contatar o suporte pelo e-mail <strong>${email}</strong>.</p>
  </div>
</div>

<div class="footer">
  &nbsp;
</div>
</body>
</html>
