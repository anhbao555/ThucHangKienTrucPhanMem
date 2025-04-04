# Sử dụng Node.js 18 làm base image
FROM node:18

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file vào container
COPY package*.json ./
RUN npm install

COPY . .

# Expose cổng 3000
EXPOSE 3000

# Chạy ứng dụng
CMD ["node", "server.js"]
