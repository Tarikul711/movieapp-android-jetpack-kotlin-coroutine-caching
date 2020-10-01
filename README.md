# movieapp-android-jetpack-kotlin-coroutine-caching

https://api.themoviedb.org/3/discover/movie?api_key=73600704c1c70585df13771486247174&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1

https://image.tmdb.org/t/p/w185_and_h278_bestv2      
my api key  :   c4519d9993a9c4b6576e45741333593a




api read access token :  eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNDUxOWQ5OTkzYTljNGI2NTc2ZTQ1NzQxMzMzNTkzYSIsInN1YiI6IjU5OGJmNjM5OTI1MTQxMDgwMTAwOWM0MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.sSnejxx-FYauHtyw0g1N_VJPf9ujgmDZUOioaHlIrtM


https://api.themoviedb.org/3/trending/all/day?api_key=c4519d9993a9c4b6576e45741333593a




==================== Sample API Part Here ================================




// 20200930114204
// https://api.themoviedb.org/3/trending/all/day?api_key=c4519d9993a9c4b6576e45741333593a

{
  "page": 1,
  "results": [
    {
      "id": 497582,
      "video": false,
      "vote_count": 1186,
      "vote_average": 7.8,
      "title": "Enola Holmes",
      "release_date": "2020-09-23",
      "original_language": "en",
      "original_title": "Enola Holmes",
      "genre_ids": [
        12,
        80,
        18,
        9648
      ],
      "backdrop_path": "/kMe4TKMDNXTKptQPAdOF0oZHq3V.jpg",
      "adult": false,
      "overview": "While searching for her missing mother, intrepid teen Enola Holmes uses her sleuthing skills to outsmart big brother Sherlock and help a runaway lord.",
      "poster_path": "/riYInlsq2kf1AWoGm80JQW5dLKp.jpg",
      "popularity": 1048.736,
      "media_type": "movie"
    },
    {
      "id": 621870,
      "video": false,
      "vote_count": 72,
      "vote_average": 7.6,
      "title": "Secret Society of Second Born Royals",
      "release_date": "2020-09-25",
      "original_language": "en",
      "original_title": "Secret Society of Second Born Royals",
      "genre_ids": [
        28,
        12,
        35,
        14
      ],
      "backdrop_path": "/uN4BEmphubHVBSFibqiOwi7wq28.jpg",
      "adult": false,
      "overview": "Sam is a teenage royal rebel, second in line to the throne of the kingdom of Illyria. Just as her disinterest in the royal way of life is at an all-time high, she discovers she has super-human abilities and is invited to join a secret society of similar extraordinary second-born royals charged with keeping the world safe.",
      "poster_path": "/x0fojycYFbT0eqXXbEO6aDqkalX.jpg",
      "popularity": 234.091,
      "media_type": "movie"
    },
    {
      "original_name": "Fargo",
      "id": 60622,
      "name": "Fargo",
      "vote_count": 1336,
      "vote_average": 8.3,
      "first_air_date": "2014-04-15",
      "poster_path": "/9ZIhl17uFlXCNUputSEDHwZYIEJ.jpg",
      "genre_ids": [
        80,
        18
      ],
      "original_language": "en",
      "backdrop_path": "/xcJLhsFGVC4LVvucSqVXks2mnUJ.jpg",
      "overview": "A close-knit anthology series dealing with stories involving malice, violence and murder based in and around Minnesota.",
      "origin_country": [
        "US"
      ],
      "popularity": 106.854,
      "media_type": "tv"
    },
    {
      "id": 337401,
      "video": false,
      "vote_count": 2101,
      "vote_average": 7.4,
      "title": "Mulan",
      "release_date": "2020-09-04",
      "original_language": "en",
      "original_title": "Mulan",
      "genre_ids": [
        28,
        12,
        18,
        14
      ],
      "backdrop_path": "/zzWGRw277MNoCs3zhyG3YmYQsXv.jpg",
      "adult": false,
      "overview": "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.",
      "poster_path": "/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg",
      "popularity": 1139.529,
      "media_type": "movie"
    },
    {
      "original_name": "The Boys",
      "id": 76479,
      "name": "The Boys",
      "vote_count": 2361,
      "vote_average": 8.4,
      "first_air_date": "2019-07-25",
      "poster_path": "/mY7SeH4HFFxW1hiI6cWuwCRKptN.jpg",
      "genre_ids": [
        10759,
        10765
      ],
      "original_language": "en",
      "backdrop_path": "/mGVrXeIjyecj6TKmwPVpHlscEmw.jpg",
      "overview": "A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.",
      "origin_country": [
        "US"
      ],
      "popularity": 1533.795,
      "media_type": "tv"
    },
    {
      "id": 499932,
      "video": false,
      "vote_count": 785,
      "vote_average": 7.4,
      "title": "The Devil All the Time",
      "release_date": "2020-09-11",
      "original_language": "en",
      "original_title": "The Devil All the Time",
      "genre_ids": [
        80,
        18,
        53
      ],
      "backdrop_path": "/rUeqBuNDR9zN6vZV9kpEFMtQm0E.jpg",
      "adult": false,
      "overview": "In Knockemstiff, Ohio and its neighboring backwoods, sinister characters converge around young Arvin Russell as he fights the evil forces that threaten him and his family.",
      "poster_path": "/7G2VvG1lU8q758uOqU6z2Ds0qpA.jpg",
      "popularity": 288.877,
      "media_type": "movie"
    },
    {
      "id": 741067,
      "video": false,
      "vote_count": 4,
      "vote_average": 7.3,
      "title": "Welcome to Sudden Death",
      "release_date": "2020-09-29",
      "original_language": "en",
      "original_title": "Welcome to Sudden Death",
      "genre_ids": [
        28,
        18,
        53
      ],
      "backdrop_path": "/mc48QVtMhohMFrHGca8OHTB6C2B.jpg",
      "adult": false,
      "overview": "Jesse Freeman is a former special forces officer and explosives expert now working a regular job as a security guard in a state-of-the-art basketball arena. Trouble erupts when a tech-savvy cadre of terrorists kidnap the team's owner and Jesse's daughter during opening night. Facing a ticking clock and impossible odds, it's up to Jesse to not only save them but also a full house of fans in this highly charged action thriller.",
      "poster_path": "/elZ6JCzSEvFOq4gNjNeZsnRFsvj.jpg",
      "popularity": 44.727,
      "media_type": "movie"
    },
    {
      "original_name": "Raised by Wolves",
      "id": 85723,
      "name": "Raised by Wolves",
      "vote_count": 274,
      "vote_average": 7.6,
      "first_air_date": "2020-09-03",
      "poster_path": "/mTvSVKMn2Npf6zvYNbGMJnYLtvp.jpg",
      "genre_ids": [
        18,
        10765
      ],
      "original_language": "en",
      "backdrop_path": "/na2xUduK8HviOFT97TiFG2MkJmY.jpg",
      "overview": "After Earth is ravaged by a great religious war, an atheistic android architect sends two of his creations, Mother and Father, to start a peaceful, godless colony on the planet Kepler-22b. Their treacherous task is jeopardized by the arrival of the Mithraic, a deeply devout religious order of surviving humans.",
      "origin_country": [
        "US"
      ],
      "popularity": 414.977,
      "media_type": "tv"
    },
    {
      "original_name": "Patria",
      "id": 85964,
      "name": "Patria",
      "vote_count": 1,
      "vote_average": 7.0,
      "first_air_date": "2020-09-27",
      "poster_path": "/yTvhNt0QxXG7ww5hrUQwFtQoKIw.jpg",
      "genre_ids": [
        80,
        18
      ],
      "original_language": "es",
      "backdrop_path": "/2FdeV6TxG02XL5nBF9NUvoi1BkW.jpg",
      "overview": "A look at the impact of Spain’s Basque conflict on ordinary people on both sides, such as the widow of a man killed by the ETA who returns to her home village after the 2011 ceasefire between the separatist group and the Spanish government, and her former intimate friend, the mother of a jailed terrorist.",
      "origin_country": [
        "ES"
      ],
      "popularity": 110.627,
      "media_type": "tv"
    },
    {
      "backdrop_path": "/yYhu8ED3DxwzoLhdH5nlfMPJrXY.jpg",
      "first_air_date": "2020-09-25",
      "genre_ids": [
        18,
        10759,
        9648
      ],
      "id": 78903,
      "name": "Utopia",
      "origin_country": [
        "US"
      ],
      "original_language": "en",
      "original_name": "Utopia",
      "overview": "A group of young adults who met online are mercilessly hunted by a shadowy deep state organization after they come into possession of a near-mythical cult underground graphic novel.",
      "poster_path": "/1n16NtV4rNY3PDzy4FLisTI7pwQ.jpg",
      "vote_average": 8.4,
      "vote_count": 8,
      "popularity": 145.597,
      "media_type": "tv"
    },
    {
      "backdrop_path": "/joEPlCHbuC3fa2dYxqbrPb2ozYx.jpg",
      "first_air_date": "2020-09-25",
      "genre_ids": [
        10765
      ],
      "id": 87313,
      "name": "The School Nurse Files",
      "origin_country": [
        "KR"
      ],
      "original_language": "ko",
      "original_name": "보건교사 안은영",
      "overview": "Wielding a light-up sword through the dark corners of a high school, a nurse with an unusual gift protects students from monsters only she can see.",
      "poster_path": "/hTNsIF9fnlDPH0xitWPyzMbOi2E.jpg",
      "vote_average": 6.8,
      "vote_count": 6,
      "popularity": 39.194,
      "media_type": "tv"
    },
    {
      "id": 501979,
      "video": false,
      "vote_count": 202,
      "vote_average": 6.4,
      "title": "Bill & Ted Face the Music",
      "release_date": "2020-08-27",
      "original_language": "en",
      "original_title": "Bill & Ted Face the Music",
      "genre_ids": [
        12,
        35,
        878
      ],
      "backdrop_path": "/oazPqs1z78LcIOFslbKtJLGlueo.jpg",
      "adult": false,
      "overview": "Yet to fulfill their rock and roll destiny, the now middle-aged best friends Bill and Ted set out on a new adventure when a visitor from the future warns them that only their song can save life as we know it. Along the way, they are helped by their daughters, a new batch of historical figures and a few music legends—to seek the song that will set their world right and bring harmony to the universe.",
      "poster_path": "/4V2nTPfeB59TcqJcUfQ9ziTi7VN.jpg",
      "popularity": 196.263,
      "media_type": "movie"
    },
    {
      "id": 577922,
      "video": false,
      "vote_count": 1850,
      "vote_average": 7.5,
      "title": "Tenet",
      "release_date": "2020-08-22",
      "original_language": "en",
      "original_title": "Tenet",
      "genre_ids": [
        28,
        878,
        53
      ],
      "backdrop_path": "/wzJRB4MKi3yK138bJyuL9nx47y6.jpg",
      "adult": false,
      "overview": "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
      "poster_path": "/k68nPLbIST6NP96JmTxmZijEvCA.jpg",
      "popularity": 167.308,
      "media_type": "movie"
    },
    {
      "original_name": "The Third Day",
      "id": 90259,
      "name": "The Third Day",
      "vote_count": 12,
      "vote_average": 6.4,
      "first_air_date": "2020-09-14",
      "poster_path": "/rNx7hgp3Cs6YPeBgvE6enNmR1Xz.jpg",
      "genre_ids": [
        18,
        9648,
        10765
      ],
      "original_language": "en",
      "backdrop_path": "/yEvcaFO2nz8QdGVsqyVK93iLPp3.jpg",
      "overview": "A unique story told over two distinct halves, \"Summer\" follows Sam, a man drawn to a mysterious island off the British coast where he encounters a group of islanders set on preserving their traditions at any cost. \"Winter\" follows Helen, a strong-willed outsider who comes to the island seeking answers, but whose arrival precipitates a fractious battle to decide its fate.",
      "origin_country": [
        "US"
      ],
      "popularity": 156.94,
      "media_type": "tv"
    },
    {
      "original_name": "Lovecraft Country",
      "id": 82816,
      "name": "Lovecraft Country",
      "vote_count": 181,
      "vote_average": 7.2,
      "first_air_date": "2020-08-16",
      "poster_path": "/fz7bdjxPColvEWCGr5Kiclzc86d.jpg",
      "genre_ids": [
        18,
        9648,
        10765
      ],
      "original_language": "en",
      "backdrop_path": "/qx7qy2GJOc7yGY6WENyBU3OVv7A.jpg",
      "overview": "The anthology horror series follows 25-year-old Atticus Freeman, who joins up with his friend Letitia and his Uncle George to embark on a road trip across 1950s Jim Crow America to find his missing father. They must survive and overcome both the racist terrors of white America and the malevolent spirits that could be ripped from a Lovecraft paperback.",
      "origin_country": [
        "US"
      ],
      "popularity": 204.537,
      "media_type": "tv"
    },
    {
      "backdrop_path": "/adZ9ldSlkGfLfsHNbh37ZThCcgU.jpg",
      "first_air_date": "1989-12-16",
      "genre_ids": [
        16,
        35,
        10751
      ],
      "id": 456,
      "name": "The Simpsons",
      "origin_country": [
        "US"
      ],
      "original_language": "en",
      "original_name": "The Simpsons",
      "overview": "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
      "poster_path": "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
      "vote_average": 7.7,
      "vote_count": 4723,
      "popularity": 329.008,
      "media_type": "tv"
    },
    {
      "id": 299534,
      "video": false,
      "vote_count": 15163,
      "vote_average": 8.3,
      "title": "Avengers: Endgame",
      "release_date": "2019-04-24",
      "original_language": "en",
      "original_title": "Avengers: Endgame",
      "genre_ids": [
        28,
        12,
        878
      ],
      "backdrop_path": "/orjiB3oUIsyz60hoEqkiGpy5CeO.jpg",
      "adult": false,
      "overview": "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
      "poster_path": "/or06FN3Dka5tukK1e9sl16pB3iy.jpg",
      "popularity": 191.369,
      "media_type": "movie"
    },
    {
      "original_name": "The Comey Rule",
      "id": 104954,
      "name": "The Comey Rule",
      "vote_count": 2,
      "vote_average": 8.5,
      "first_air_date": "2020-09-27",
      "poster_path": "/wftjHCpgqziAw42JZWdFWhro3km.jpg",
      "genre_ids": [
        18
      ],
      "original_language": "en",
      "backdrop_path": "/zu6wRkFrBdZDhGy3CQzfsd8XQsz.jpg",
      "overview": "An immersive, behind-the-headlines account of the historically turbulent events surrounding the 2016 presidential election and its aftermath, which divided a nation. This two-part biopic tells the story of two powerful figures, Comey and Trump, whose strikingly different personalities, ethics and loyalties put them on a collision course.",
      "origin_country": [
        
      ],
      "popularity": 35.713,
      "media_type": "tv"
    },
    {
      "original_name": "The Walking Dead",
      "id": 1402,
      "name": "The Walking Dead",
      "vote_count": 7764,
      "vote_average": 7.8,
      "first_air_date": "2010-10-31",
      "poster_path": "/qgjP2OrrX9gc6M270xdPnEmE9tC.jpg",
      "genre_ids": [
        18,
        10759,
        10765
      ],
      "original_language": "en",
      "backdrop_path": "/wXXaPMgrv96NkH8KD1TMdS2d7iq.jpg",
      "overview": "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
      "origin_country": [
        "US"
      ],
      "popularity": 303.806,
      "media_type": "tv"
    },
    {
      "id": 539885,
      "video": false,
      "vote_count": 367,
      "vote_average": 6.0,
      "title": "Ava",
      "release_date": "2020-08-06",
      "original_language": "en",
      "original_title": "Ava",
      "genre_ids": [
        28,
        80,
        18,
        53
      ],
      "backdrop_path": "/54yOImQgj8i85u9hxxnaIQBRUuo.jpg",
      "adult": false,
      "overview": "A black ops assassin is forced to fight for her own survival after a job goes dangerously wrong.",
      "poster_path": "/qzA87Wf4jo1h8JMk9GilyIYvwsA.jpg",
      "popularity": 1324.742,
      "media_type": "movie"
    }
  ],
  "total_pages": 1000,
  "total_results": 20000
}
