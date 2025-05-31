# Dockerfile
FROM node:20-alpine

# Set working directory
WORKDIR /app

# Copy package files first (optimizes layer caching)
COPY package*.json ./

# Install production dependencies only
RUN npm ci --only=production

# Copy application code
COPY . .

# Expose port (match your app's port)
EXPOSE 3000

# Start command (match your package.json)
CMD ["npm", "start"]