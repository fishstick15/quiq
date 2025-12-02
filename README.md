# quiq
quiq is an unencrypted messaging system made by **nocku** in Java. 

# License
This project is licensed under the MIT License — see the [LICENSE](LICENSE) file.

# Instructions for v0.2.0-alpha and under.

1. **Port Forwarding**
  To be able to communicate across different machines with quiq, a port forward on TCP port 5000 is required.

2. **Running the programs**
  - Run `Receive.exe` (the program that receives messages)
  - Then run `Send.exe` (the program that sends messages)
  - **Important:** The names of the programs will **NOT** match with the examples. Also, make sure to run `Receive.exe` *before* setting the ip on `Send.exe` otherwise, `Send.exe` will crash.

3. **Notes for**
  This program does **not** encrypt messages. This project is a proof-of-concept meant for learning, and does not have any sort of encryption. Any data sent will be visible on the network.
  To test the program by yourself, simply set the IP Address in `Send.exe` to '127.0.0.1'.

# Instructions for v0.3.0-alpha.

1. **Port Forwarding**
  To be able to communicate across different machines with quiq, a port forward on TCP port 5000 is required.

2. **Running the programs**
  - Run `quiq [enter your quiq version here]`
  - **Important:** The name of the program will probably not match with the example. Also, make sure to run host a socket **before** setting the ip to join.

3. **Notes**
  This program does **not** encrypt messages. This project is a proof-of-concept meant for learning, and does not have any sort of encryption. Any data sent will be visible on the network.
  To test the program by yourself, you need to run two versions of the program and set the join IP to 127.0.0.1. *you do not need a port-forward open to test by yourself.*

# Author
This program was made by **nocku** (also known as *fishstick15*)
Github: [https://github.com/fishstick15](https://github.com/fishstick15)
