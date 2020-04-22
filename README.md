# JoinWorldCommand

A simple plugin that makes it possible to add commands that execute when a player joins a world.

## Features
- Color code support
- Player placeholder
- Send commands as Console or Player
- Json support in form of tellraw command
- Create join message with link!



## To-Do

- Fix set command

##### *Optional:*
- Use placeholder api?
- Multiple commands (Has to be done with arraylist I suppose)
- Permission based. Only run command if you have the permission.

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
#  world: #This is the name of your world.
#    command: hello #This is the command you want to execute. Use %player% for the name of the player that joins the world.
#    executor: player #Who executes the command, player or console.
# Example to create a join message: tellraw @a {"text":"%player% joined the world!", "color":"gold"}
#
world_commands:
  world:
    command: hello
    executor: player
  world_the_end:
    command: hello
    executor: console
```

##### Commands

-/jwc reload </br>  
-/hello

##### Permissions

-jwc.reload </br>  
-jwc.hello
