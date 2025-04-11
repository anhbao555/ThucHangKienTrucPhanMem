# Sử dụng image node chính thức
FROM node:18

# Tạo thư mục làm việc trong container
WORKDIR /app

# Copy file vào container
COPY package*.json ./
RUN npm install
COPY . .

# Cổng mà app sử dụng
EXPOSE 3000

# Lệnh chạy ứng dụng
CMD ["npm", "start"]
