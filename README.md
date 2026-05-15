# SimpleServerTransfer

A Paper/Spigot plugin that uses the vanilla Transfer packet (introduced in 1.20.5) to automatically redirect players to another server when they join. Designed to act as a lightweight transfer proxy layer without requiring BungeeCord or Velocity.

## Downloads

Releases are available on the [releases page](https://github.com/darkflareplays8/Simple-Server-Transfer/releases).

## Requirements

- Java 21 (Java 25 for the 26.1.x Paper release)
- The destination server must accept vanilla Transfer packets (1.20.5+, with `accepts-transfers: true` in paper-global.yml)

## Features

- Transfers players to a configurable host and port after a configurable tick delay
- Optional Geyser/Floodgate support to send Bedrock players to a separate target
- Optional server limiter mode that suppresses mob spawning, block interaction, damage, weather, and world saving to reduce load while the server acts purely as a transfer relay

## Configuration

All options are in `config.yml`. The file is generated on first run and documented with inline comments. A full server restart is required for any changes to take effect.

The `proxy-mode` option is the master switch. When set to `false` the plugin does nothing.

## Compatibility

| Software | Version Range | Supported |
|---|---|---|
| Paper | 1.20.6 - 1.21.x | Yes |
| Paper | 26.1.x | Yes (separate release) |
| Spigot | 1.20.6 - 1.21.x | Yes (separate release) |
| Purpur | 1.20.6 - 1.21.x | Yes (uses Paper release) |
| Geyser + Floodgate | Any | Optional |
| BungeeCord / Velocity | Any | No |

## License

MIT
