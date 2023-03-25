#!/bin/bash

echo "Please enter your password"
read user_password

if [ $user_password = "lameAssPassword" ] 
then 
 echo "The password is correct 🎉"
else
 echo "The password is not correct... Goodbye 👋"
fi