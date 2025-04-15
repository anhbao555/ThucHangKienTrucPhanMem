# Sử dụng Node.js 18 Alpine làm base image
FROM node:18-alpine

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép package.json và package-lock.json để cài đặt dependencies trước
COPY package*.json ./

# Cài đặt dependencies
RUN npm install

# Sao chép toàn bộ code vào container
COPY . .

# Build ứng dụng
RUN npm run build

# Mở cổng 3001
EXPOSE 3001

# Chạy ứng dụng
CMD ["npm", "run", "preview"]
