#!/usr/bin/env python3
"""Regenerates the auto-generated stats block in README.md by counting solved
problems per language. Run via the pre-commit hook in .githooks/pre-commit."""

import re
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
README = ROOT / "README.md"

START_MARKER = "<!-- STATS:START -->"
END_MARKER = "<!-- STATS:END -->"

LANGUAGES = {
    "Python": {
        "path": ROOT / "python" / "solutions",
        "pattern": re.compile(r"^\d{4}-.+\.py$"),
    },
    "Java": {
        "path": ROOT / "java" / "src" / "main" / "java" / "org" / "example" / "solutions",
        "pattern": re.compile(r"^Solution\d{1,4}\.java$"),
    },
}


def count_solutions():
    counts = {}
    for language, cfg in LANGUAGES.items():
        if not cfg["path"].is_dir():
            counts[language] = 0
            continue
        counts[language] = sum(
            1 for f in cfg["path"].iterdir() if f.is_file() and cfg["pattern"].match(f.name)
        )
    return counts


def build_stats_block(counts):
    lines = [START_MARKER, "", "| Language | Solved |", "| --- | --- |"]
    for language, count in counts.items():
        lines.append(f"| {language} | {count} |")
    lines.append("")
    lines.append(END_MARKER)
    return "\n".join(lines)


def update_readme():
    counts = count_solutions()
    stats_block = build_stats_block(counts)

    if README.exists():
        content = README.read_text()
    else:
        content = ""

    if START_MARKER in content and END_MARKER in content:
        pattern = re.compile(
            re.escape(START_MARKER) + r".*?" + re.escape(END_MARKER), re.DOTALL
        )
        content = pattern.sub(stats_block, content)
    else:
        if content and not content.endswith("\n\n"):
            content = content.rstrip("\n") + "\n\n"
        content += stats_block + "\n"

    README.write_text(content)
    return counts


if __name__ == "__main__":
    counts = update_readme()
    print("Updated README.md solved counts:", counts)
