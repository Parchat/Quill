<div align="center">

# Quill
<p>An experimental fork of <a href="https://github.com/PurpurMC/Purpur">Purpur</a> including <a href="https://github.com/Bloom-host/Petal">Petal</a> patches aiming to finish where they left off.</p>

It does not mean our sole focus will be on what Petal has left but that is part of it.<br></br>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![GPU License][license-shield]][license-url]
[![Contact][discord-shield]][discord-url]

<br>

> __Warning__<br>
> This project is considered experimental and should not be used in production until told otherwise.<br>
> Will it ever be stable? It is highly likely that it won't be, but we can always try.
>
> We color grade our features in terms of the state they are in. You can find that "legend" below.<br>
>$\color{#24cc18}\textsf{\Large\&#x24D8;\kern{0.2cm}\normalsize Stable Feature}$<br>
>$\color{#cee026}\textsf{\Large\&#x24D8;\kern{0.2cm}\normalsize Testing Feature}$<br>
>$\color{#eb2135}\textsf{\Large\&#x24D8;\kern{0.2cm}\normalsize Unstable Feature}$<br>
>$\color{#cf8313}\textsf{\Large\&#x24D8;\kern{0.2cm}\normalsize Deprecated Feature}$

</div>

## Features

> __Note__<br>
> Quill will include 2 patches from Petal that mark significant improvements for entity-heavy servers, They are **VERY** unstable.

$\color{#eb2135}\textsf{\Large\&#x24D8;\kern{0.2cm}\normalsize Async Pathfinding}$<br>
- Entity pathfinding is offloaded to asynchronous threads to significantly reduce processing from the main thread.

$\color{#eb2135}\textsf{\Large\&#x24D8;\kern{0.2cm}\normalsize Multi-threaded Entity Tracking}$<br>
- Entity tracking can take advantage of multiple threads to greatly reduce dependence on main thread processing.

## FAQ

- Will you include Pufferfish patches?
  - As long as Purpur does.
- Why do you waste your time with this?
  - I like to waste my time.
- ./gradlew applyPatches
- Hit "i" to switch to edit mode in vim when editing patches.
- Type :wq to save the file.

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