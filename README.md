# quiq
quiq is an unencrypted messaging system made by **nocku** in Java. 

# License
This project is licensed under the MIT License — see the [LICENSE](LICENSE) file.

# Instructions

1. **Port Forwarding**
  To be able to communicate across different machines with quiq, a port forward on TCP port 5000 is required.

2. **Running the programs**
  - Run 'Receive.exe' (the program that receives messages)
  - Then run 'Send.exe' (the program that sends messages)
  - **Important:** The names of the programs will **NOT** match with the examples. Also, make sure to run 'Receive.exe' *before* setting the ip on 'Send.exe' otherwise, 'Send.exe' will crash.

3. **Notes**
  This program does **not** encrypt messages. This project is a proof-of-concept meant for learning, and does not have any sort of encryption. Any data sent will be visible on the network.
  To test the program by yourself, simply set the IP Address in 'Send.exe' to '127.0.0.1'.

4. **Author**
   This program was made by *nocku*, also known as *fishstick15* in some places.
   Github: [https://github.com/fishstick15](https://github.com/fishstick15)
