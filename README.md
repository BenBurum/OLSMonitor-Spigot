# OLSMonitor-Spigot
# Oasis Light Server Monitor
## Overview:

OLSMonitor is a simple Minecraft plugin to monitor server data.  For full functionality such as crash/inactivity monitoring, automatic restarts, and more it is highly recommended that you use it in conjunction with the [Oasis Light Server Manager](https://github.com/OasisArtisan/OasisLight-ServerManager) java program by OasisArtisan.  OSLSMonitor can also be used as a standalone plugin to print server data to the console and to a file.  The available data to monitor include RAM use, CPU use, server TPS, and player count.

## Config:
### The following options are configurable in config.yml

*print debug messages to the console*
debug-mode: false


*print the monitor data to console (ram, cpu, tps, playercount)*
print-data-to-console: true


*enable RAM monitoring*
check-ram: true


*enable CPU checking*
check-CPU: true


*enable server TPS monitoring*
check-tps: true


*enable playercount monitoring*
count-players: false


*set the name for the monitordata file.  This should be changed the name of your server, E.G. "Survival"*
monitordata-file-name: data


*Set whether to use the custom path below for the monitordata file*
custom-data-path: false


*Set a custom path for the monitordata file.  **Requires custom-data-path: true** *
custom-path-location: plugins\OLSMonitor


*interval in ticks to check and print server data.*
monitor-interval: 600


## Commands:

There is only one command for OLSMonitor: /olsmonitor reload (alias olsm reload).  This command will reload the config file.  Requires OP.

## Permissions:

None.


