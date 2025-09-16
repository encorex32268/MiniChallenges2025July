package com.lihan.minichallenges2025july.collapsiblechatthread

data class Post(
    val username: String,
    val time: String,
    val channel: String,
    val title: String,
    val content: String,
    val replies: List<Comment> = emptyList()
)

val data = listOf(
    Post(
        username = "DreamSyntaxHiker",
        time = "1 day ago",
        channel = "/Product Reflection",
        title = "I Tried to Build a Language-Learning App. It Didn't Go as Planned.",
        content = "I spent 9 months building what I thought would be a simple app to help people learn new languages through short conversations. I poured my evenings and weekends into it, but the launch was… underwhelming.\\n\\nHere's what I learned about feature creep, marketing missteps, and chasing perfection instead of feedback.",
        replies = listOf(
            Comment(
                username = "ByteBuddy88",
                time = "1 day ago",
                badge = "Top 1% Commenter",
                content = "Can relate. I thought adding 3 extra modes would help my music app. Users just wanted a clean player.",
                replies = listOf(
                    Comment(
                        username = "CodeNamedQuiet",
                        time = "1 day ago",
                        content = "Same here. I kept piling on features thinking I was being helpful. Turns out, complexity just pushed users away."
                    ),
                    Comment(
                        username = "InfiniteCoffeeStream",
                        time = "1 day ago",
                        content = "A minimal core product > overloaded app."
                    ),
                    Comment(
                        username = "APITestDummy",
                        time = "1 day ago",
                        content = "I added offline support, 5 themes, and full emoji search. No one cared. Just wanted smooth onboarding."
                    ),
                    Comment(
                        username = "RetroUXFlare",
                        time = "1 day ago",
                        content = "Too many features = too many bugs = bad reviews. Learned that the hard way."
                    ),
                )
            ),
            Comment(
                username = "MemoStacker",
                time = "1 day ago",
                badge = "Top 1% Poster",
                content = "This is a timely post. I’m in month 4 of building a journaling app. Biggest takeaway so far: don’t underestimate the effort to onboard first-time users.\\n\\nI had people open the app, stare blankly, and close it.\\n\\n- UI needs to guide the user, not just look good\\n- First use experience is everything\\n- Every extra step kills conversion"
            ),
            Comment(
                username = "CLIOverlord",
                time = "1 day ago",
                content = "My failed app taught me more than my CS degree. There\\'s no syllabus for building something strangers actually want.",
                replies = listOf(
                    Comment(
                        username = "DebugDruid",
                        time = "1 day ago",
                        content = "Truth. The gap between “this is useful to me” and “this is useful to others” is massive."
                    ),
                    Comment(
                        username = "SilentLambda",
                        time = "1 day ago",
                        content = "You don\\'t learn product-market fit in school. You learn it after shipping something no one wants."
                    ),
                )
            )
        )
    )
)