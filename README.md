# Welcome to Laudekoodit 2020

## Requirements

  - Telegram
  - Working version of java
  - git
  - Code editor such as Netbeans or vscode

## Creating your first bot

1. Go to https://telegram.me/BotFather
2. Send message '/newbot'
3. Follow instructions

Your conversation should look something like this

![conversation](images/laudekoodit.png)

You can now start messaging your bot but as expected it does not answer anything. Start by forking this repository onto your own computer. This can be done by clicking the fork button on the github page.

## Connecting your bot

Open up this project on your favorite code editor. Inside src/main/java/tkoaly/pohinatiimi/laudekoodit are the files we are gonna be working with. Especially LaudeBot.java.

### Set bot username

Next open up LaudeBot.java and insert the username you gave your bot into to the getBotUsername -method.

If your bots username is official_laudebot the method should look like below

![setUsername](images/settingUsername.png)

### Set bot token 

We could insert the token directly into the getBotToken -method however this means anyone with the source code can use our unqiue bot token. That would be bad. Instead we use the dotenv package. The project has this pre-configured so all you need to is follow the steps below.

  1. Create a file called '.env' inside root directory
  2. Inside the file write 'TOKEN=[INSERT YOUR TOKEN HERE]" without the brackets

**Congratulations! Your bot should now be working!!**

### More information

Visit https://github.com/rubenlagus/TelegramBots/wiki for more information

### Errors

If you get an error like below it means your token is not setup right. Remember to restart your computer after updating .bashrc

![error](images/error.png)