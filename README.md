# JoinWorldCommand

A simple plugin that makes it possible to add commands that execute when a player joins a world.

## Features
- Send command when joining world and/or server
- Module based
- Control which command is being executed with custom permissions
- Color code support
- Player placeholder
- Send commands as Console or Player
- Json support in form of tellraw command
- Create join message with link!


## To-Do
  - Add a delay in commands
  - Placeholderapi?

###### Config.yml:

```sh
############################################################
# +------------------------------------------------------+ #
# |                   JoinWorldCommand                   | #
# +------------------------------------------------------+ #
##################Thanks for downloading!###################
#
#
#world_commands:
#  world: #This is the name of your world. Permission to trigger command is jwc.world.<world-name>
#    command: hello #This is the command you want to execute. Use %player% for the name of the player that joins the world.
#    executor: player #Who executes the command, player or console.
# Example to create a join message: tellraw @a {"text":"%player% joined the world!", "color":"gold"}
#
enable_world_commands: true
world_commands:
  world:
    command: hello
    executor: player
  world_the_end:
    command: hello
    executor: console

#server_commands:
#  first_command: #This can be anything you want and is the last part in the permission to trigger the command. In this example jwc.server.first_command
#    command: hello #This is the command you want to execute. Use %player% for the name of the player that joins the world.
#    executor: player #Who executes the command, player or console.
enable_server_commands: false
server_commands:
  first_command:
    command: hello
    executor: player
```

##### Commands

  - /jwc reload   
  - /jwc world
  - /jwc server
  - /hello  

##### Permissions


  - jwc.reload    
  - jwc.hello  
  - jwc.server.'command'  
  - jwc.world.'world-name'

Spigot link: https://www.spigotmc.org/resources/joinworldcommand.67307/
