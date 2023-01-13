<div style="text-align: center">

## Quill
<p>An experimental fork of <a href="https://github.com/PurpurMC/Purpur">Purpur</a> including <a href="https://github.com/Bloom-host/Petal">Petal</a> patches aiming to finish where they left off.</p>

It does not mean our sole focus will be on what Petal has left but that is part of it.<br></br>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![GPU License][license-shield]][license-url]
[![Contact][discord-shield]][discord-url]

### Warning

<ul style="list-style-position: inside">
    <li style="color: yellow">This project is considered experimental & should not be used in production until told otherwise.</li>
    <li style="color: yellow">Will it ever be stable? Probably not but We'll try.</li>
</ul>

<p>We color grade our features in terms of the state they are in. You can find that "legend" below.</p>

<ul style="list-style-position: inside">
    <li style="color: greenyellow; display: inline;padding-right: 6px;">Stable Feature</li>
    <li style="color: yellow; display: inline;padding-right: 6px;">Testing Feature</li>
    <li style="color: red; display: inline;padding-right: 6px;">Unstable Feature</li>
    <li style="color: darkkhaki; display: inline;">Deprecated Feature</li>
</ul>

</div>

---
## Features
Quill will include 2 patches from Petal that mark significant improvements for entity-heavy servers, They are **VERY** unstable.

<ul style="">
    <li style="color: red;"><b>Async Pathfinding</b></li> - Entity pathfinding is offloaded to asynchronous threads to significantly reduce processing from the main thread
    <li style="color: red;"><b>Multi-threaded Entity Tracking</b></li>- Entity tracking can take advantage of multiple threads to greatly reduce dependence on main thread processing
</ul>

## FAQ

- Will you include Pufferfish patches?
  - As long as Purpur does.
- Why do you waste your time with this?
  - I like to waste my time.
- ./gradlew applyPatches

## License

Distributed under the MIT License. See [`LICENSE`](/LICENSE) for more information.

[discord-shield]: https://img.shields.io/discord/982773962771689472.svg?style=flat&logo=appveyor
[discord-url]: https://discord.gg/MrmHTnUrM8

[contributors-shield]: https://img.shields.io/github/contributors/Parchat/Quill.svg?style=flat&logo=appveyor
[contributors-url]: https://github.com/Parchat/Quill/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Parchat/Quill.svg?style=flat&logo=appveyor
[forks-url]: https://github.com/Parchat/Quill/network/members
[stars-shield]: https://img.shields.io/github/stars/Parchat/Quill.svg?style=flat&logo=appveyor
[stars-url]: https://github.com/Parchat/Quill/stargazers
[issues-shield]: https://img.shields.io/github/issues/Parchat/Quill.svg?style=flat&logo=appveyor
[issues-url]: https://github.com/Parchat/Quill/issues
[license-shield]: https://img.shields.io/github/license/Parchat/Quill.svg?style=flat&logo=appveyor
[license-url]: https://github.com/Parchat/Quill/blob/master/LICENSE