# zusammen

## Instructions for Windows
Before running maven goal `generate-ressources`, please
make sure your have builds tools correctly configured.

An easy way to set-up build tools on `Windows` is
to use `windows-build-tools`.

Start by installing `node` and `npm` globally in your
system, then run (as administrator):
```bash
npm install --global --production windows-build-tools
npm config set msvs_version 2017
```
