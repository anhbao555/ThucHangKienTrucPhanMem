const express = require('express');
const mysql = require('mysql2');

const app = express();
const port = 3000;

const connection = mysql.createConnection({
  host: 'mysql', // tên service trong docker-compose
  user: 'user',
  password: 'password',
  database: 'mydb'
});

connection.connect(err => {
  if (err) {
    console.error('MySQL connect error:', err);
    return;
  }
  console.log('Connected to MySQL');
});

app.get('/', (req, res) => {
  res.send('✅ Node.js connected to MySQL via Docker Compose!');
});

app.listen(port, () => {
  console.log(`App listening at http://localhost:${port}`);
});
