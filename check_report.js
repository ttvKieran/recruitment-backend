const fs = require('fs');
const html = fs.readFileSync('newman/recruitment-2026-04-11-03-23-36-427-0.html', 'utf8');
const match = html.match(/var templateData = \"([^\"]+)\"/);
if (match) {
    const data = JSON.parse(Buffer.from(match[1], 'base64').toString('utf8'));
    console.log('Total Failures:', data.run.failures.length);
    if (data.run.failures.length > 0) {
        console.log('First Failure Message:', data.run.failures[0].error.message);
    }
} else {
    console.log('No templateData found.');
}
