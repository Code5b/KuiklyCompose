#!/bin/bash

# Clean up miniApp dist directories
rm -rf miniApp/dist/assets/
rm -rf miniApp/dist/business/
rm -rf miniApp/dist/lib/

# Start npm serve
npm run serve &
NPM_SERVE_PID=$!

# Build shared project Debug version
./gradlew :shared:packLocalJsBundleDebug

# Build miniApp project and run miniApp server Debug version
./gradlew :miniApp:jsMiniAppDevelopmentWebpack &
MINIAPP_SERVER_PID=$!

# Copy business assets to miniApp directory
./gradlew :miniApp:copyAssets

# Wait for background processes to finish (optional, depending on desired behavior)
wait $NPM_SERVE_PID
wait $MINIAPP_SERVER_PID

echo "Development servers started and assets copied."