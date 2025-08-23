#!/bin/bash

# Check if we are in a Git repository
if [ ! -d .git ]; then
    echo "This script must be run in a Git repository"
    echo "..."
    exit 1
fi

# Find all .DS_Store files and directories
ds_store_files=$(find . -name ".DS_Store")

# Untrack .DS_Store files and directories if they exist
if [ -n "$ds_store_files" ]; then
    echo "Untracking .DS_Store files and directories"
    echo "..."
    git rm -r --cached $ds_store_files

    # Delete the .DS_Store files and directories
    echo "Deleting .DS_Store files and directories"
    echo "..."
    find . -name ".DS_Store" -exec rm -rf {} +
else
    echo "No .DS_Store files or directories found 👻"
    echo "..."
fi

# Add .DS_Store to .gitignore if it's not already there
if ! grep -q ".DS_Store" .gitignore; then
    echo ".DS_Store" >> .gitignore
    echo ".DS_Store added to .gitignore 🚫"
    echo "..."
fi

# Commit the changes if any .DS_Store files were processed
if [ -n "$ds_store_files" ]; then
    git add .
    git commit -m "Stop tracking and delete .DS_Store files and directories"
    git push
    echo "All .DS_Store files or folder deleted 🗑️"
    echo "..."
else
    echo "No changes to commit."
fi