
# meta-tinker

`meta-tinker` is a Yocto layer for building Tinker-specific Linux images. It includes recipes for the Tinker platform, additional packages, configurations, and tools. This layer also integrates customizations for RAUC (Robust Auto-Update Controller) to enable Over-the-Air (OTA) updates for the Tinker platform.

The outputs of the build process are:
- **ControlCenter Panel**: A kiosk-style device image for a control panel.
- **HomeSensorHub**: A Raspberry Pi-based image with connected sensors for home automation.

## Usage

To integrate the `meta-tinker` layer into your Yocto build:

```bash
bitbake-layers add-layer /path/to/meta-tinker
```

## License

This layer is released under the MIT license.
