FROM mcr.microsoft.com/vscode/devcontainers/java:0-11

# Install Android SDK
RUN sudo apt-get update && sudo apt-get install -y \
    android-sdk \
    && sudo apt-get clean

# Set environment variables
ENV ANDROID_HOME /usr/lib/android-sdk
ENV PATH $PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
