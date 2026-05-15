# SimpleServerTransfer

A Paper plugin that uses the vanilla Transfer packet (introduced in 1.20.5) to automatically redirect players to another server when they join. Designed to act as a lightweight transfer proxy layer without requiring BungeeCord or Velocity.

## Downloads

Both a normal jar and a shaded jar are available on the [releases page](https://github.com/darkflareplays8/Simple-Server-Transfer/releases). Most users should use the normal jar.

## Requirements

- Paper 1.20.5 or later
- Java 21
- The destination server must accept vanilla Transfer packets (1.20.5+, with `accepts-transfers: true` in paper-global.yml)

## Features

- Transfers players to a configurable host and port after a configurable tick delay
- Optional Geyser/Floodgate support to send Bedrock players to a separate target
- Optional server limiter mode that suppresses mob spawning, block interaction, damage, weather, and world saving to reduce load while the server acts purely as a transfer relay

## Configuration

All options are in `config.yml`. The file is generated on first run and documented with inline comments. A full server restart is required for any changes to take effect.

The `proxy-mode` option is the master switch. When set to `false` the plugin does nothing.

Geyser support requires both Geyser and Floodgate to be present on the server. The plugin detects Bedrock players via the Floodgate API at runtime using reflection, so the server will start fine without them as long as `geyser-support` is set to `false`.

## Compatibility

| Software | Supported |
|---|---|
| Paper 1.20.5 - 1.21.x | Yes |
| Paper 26.1.x | Separate release |
| Geyser + Floodgate | Optional |
| Spigot / CraftBukkit | No |

## License

MIT
