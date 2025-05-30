# Use official Node.js 20 image (matches  Practical 4 setup)
FROM node:20-alpine

# Set working directory - follows Jenkins best practices
WORKDIR /usr/src/app

# Copy package files first for optimal layer caching
COPY package*.json ./

# Install exact versions - ensures consistency
RUN npm ci --only=production

# Copy app source - done separately to leverage caching
COPY . .

# Expose port 3000 - standard for Node.js apps
EXPOSE 3000

# Runtime command - matches your package.json
CMD ["npm", "start"]